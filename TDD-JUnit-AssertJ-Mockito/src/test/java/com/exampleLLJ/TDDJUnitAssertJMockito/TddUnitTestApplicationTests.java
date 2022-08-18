package com.exampleLLJ.TDDJUnitAssertJMockito;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

// 接口测试，集成测试，外界交互
@SpringBootTest
@AutoConfigureMockMvc
class TddUnitTestApplicationTests {

	@Autowired
	MockMvc mockMvc;
	// 测试
	@Test
	void getRightNumber() throws Exception {
		mockMvc.perform(get("/right/number"))
				.andExpect(status().is(200))
				.andExpect(content().string("255"));

	}

	@Test
	void postOneBand() throws Exception {
		String band = "{\"bandId\": 4, \"name\": \"ColdPlay\", \"price\": 50000}";
		mockMvc.perform(post("/bands")
						.contentType(MediaType.APPLICATION_JSON).content(band))
				.andExpect(status().isOk());
	}

	@RepeatedTest(4)
	void listBands() throws Exception {
		mockMvc.perform(get("/bands"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(
						"[{\"bandId\":4,\"name\":\"ColdPlay\",\"price\":50000}]"
				));
	}

	@Test
	@EnabledOnOs({OS.LINUX, OS.WINDOWS})
	void tryBasicNumb() {
		assertEquals(2, 1+1);
		assertEquals(6, 2*3);
		assertThat(5).isCloseTo(5, Percentage.withPercentage(5));
		assertThat(5.23).isCloseTo(5, Percentage.withPercentage(5));
	}

	// 可以用于单元测试的Mockito框架
	@Test
	void testMockClass() {
		//模拟创建一个List对象
		List mock = mock(List.class);
		//使用mock的对象
		mock.add(1);
		mock.clear();
		//验证add(1)和clear()行为是否发生
		verify(mock).add(1);
		verify(mock).clear();
	}

	@Test
	void testMockExpectation() {
		//mock一个Iterator类
		Iterator iterator = mock(Iterator.class);
		//预设当iterator调用next()时第一次返回hello，第n次都返回world
		when(iterator.next()).thenReturn("hello").thenReturn("world");
		//使用mock的对象
		String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
		//验证结果
		assertEquals("hello world world",result);
	}

	@Test
	public void reset_mock(){
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		list.add(1);
		assertEquals(10,list.size());
		//重置mock，清除所有的互动和预设
		reset(list);
		assertEquals(0,list.size());
	}

}
