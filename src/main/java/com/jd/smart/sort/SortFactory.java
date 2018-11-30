/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>描述：排序算法工厂</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-16<br/>
 *
 */
public class SortFactory {

    private static Map<String, Sort> ALG_MAP = new HashMap<>();

    static {
        ALG_MAP.put("Selection", new SelectionSort());
        ALG_MAP.put("Insertion", new InsertionSort());
        ALG_MAP.put("Shell", new ShellSort());
        ALG_MAP.put("MergeUB", new MergeSortUB());
        ALG_MAP.put("MergeBU", new MergeSortBU());
    }

    public static Sort getSortAlg(String alg) {
        return ALG_MAP.get(alg);
    }
}