package com.ypyay.comm.url;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

@Slf4j
@SpringBootTest
public class httpTest {

    @Test
    void url(){
        URL url= new URL("www.baidu.com");
    }
}
