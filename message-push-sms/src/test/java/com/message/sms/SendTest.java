package com.message.sms;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class SendTest {

    @Test
    void testSendBatchSmsPrevious() {
        String signName = "message-push";
        int random = new Random().nextInt(100000);
        Map<String, Integer> param = Collections.singletonMap("code", random);

        List<String> phoneNumbers = new ArrayList<>() {{
            add("13083529161");
            add("13052854811");
            add("13092628877");
            add("13151152201");
            add("13063813990");
        }};

        String s = JSON.toJSONString(phoneNumbers);
        System.out.println(s);

        List<String> strings = Collections.nCopies(phoneNumbers.size(), signName);
        System.out.println(JSON.toJSONString(strings));

        String paramString = JSON.toJSONString(param);
        List<String> paramArray = Collections.nCopies(phoneNumbers.size(), paramString);
        String collect = paramArray.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

    @Test
    void testArrayStreamString() {
        String collect = Collections.nCopies(3, 5)
                .stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining());
        System.out.println(collect);

        collect = Collections.nCopies(3, 5)
                .stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(", "));
        System.out.println(collect);

        collect = Collections.nCopies(3, 5)
                .stream()
                .map(x -> Integer.toString(x))
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(collect);
    }
}