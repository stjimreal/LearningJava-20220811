package com.example.LearnException;

import com.example.LearnException.exceptions.DefaultAddressNotDeleteException;
import com.example.LearnException.exceptions.NotFindUserException;
import com.example.LearnException.model.Address;
import com.example.LearnException.service.IAddressService;
import com.example.LearnException.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LearnExceptionApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IAddressService addressService;

    @Autowired
    IUserService userService;


    @Test
    void successCreateAddressTest() throws NotFindUserException {
        Address address1 = new Address();
        address1.setCity("YANG ZHOU");
        address1.setProvince("Jiangsu");

//        assertEquals(address1, addressService.createAddress(1, address1));
        assertThat(addressService.createAddress(4, address1)).isEqualTo(address1);
    }

    @Test
    void failureDeleteAddressTest() throws NotFindUserException {
        List<Address> addresses = addressService.listAddresses(4);
        assertThrowsExactly(DefaultAddressNotDeleteException.class,
                ()->addressService.deleteAddress(4, addresses.get(0).getId()),
                "不可删除默认地址");
    }

    @Test
    void testApiControllerSuccess() throws Exception {
        /*
        {
            "province": "Beijing",
            "city": "HAI DIAN",
            "county": "",
            "userId": 4
        }
         */
        String addressDTOJson = "{\n" +
                                "    \"province\": \"Beijing\",\n" +
                                "    \"city\": \"HAI DIAN\",\n" +
                                "    \"county\": \"\",\n" +
                                "    \"userId\": 4\n" +
                                "}";
        mockMvc.perform(put("/address")
                .contentType(MediaType.APPLICATION_JSON).content(addressDTOJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(content().string(addressDTOJson));
    }

    @Test
    void testApiException() throws Exception {
        /*
        {
            "province": "Beijing",
            "city": "HAI DIAN",
            "county": "",
            "userId": 4
        }
         */
        String addressDTOJson = "{\n" +
                "    \"province\": \"Beijing\",\n" +
                "    \"city\": \"HAI DIAN\",\n" +
                "    \"county\": \"\",\n" +
                "    \"userId\": 1\n" +
                "}";
        mockMvc.perform(put("/address")
                        .contentType(MediaType.APPLICATION_JSON).content(addressDTOJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string(
                        "{\"errorCode\":10003,\"tip\":\"找不到此用户\"}"));
//                .andExpect(content().string(addressDTOJson));
    }

}
