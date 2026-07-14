package cn.nothinghere.brook.util;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathUtilsTest {

    @Test
    public void testJoinPathSegments() {
        String path = "$['广东省']['广州市']['天河区']";
        assertThat(JsonPathUtils.pathSegments(path)).containsExactly("广东省", "广州市", "天河区");
        assertThat(JsonPathUtils.joinPathSegments(path)).isEqualTo("广东省广州市天河区");
        assertThat(JsonPathUtils.lastPathSegment(path)).isEqualTo("天河区");
    }

    @Test
    public void testRandomKeepsPathAndValueMatched() {
        Map<String, Object> root = new LinkedHashMap<>();
        Map<String, Object> bank = new LinkedHashMap<>();
        Map<String, Object> type = new LinkedHashMap<>();
        type.put("16", Arrays.asList("A1", "A2"));
        type.put("19", Collections.singletonList("B1"));
        bank.put("DC", type);
        root.put("BANK", bank);

        for (int i = 0; i < 200; i++) {
            Map.Entry<String, Object> entry = JsonPathUtils.random(root, null, null, null);
            String length = JsonPathUtils.lastPathSegment(entry.getKey());
            if ("16".equals(length)) {
                assertThat(entry.getValue()).isIn("A1", "A2");
            } else {
                assertThat(length).isEqualTo("19");
                assertThat(entry.getValue()).isEqualTo("B1");
            }
        }
    }
}
