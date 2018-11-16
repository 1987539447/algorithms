/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

/**
 * <b>描述：排序算法接口</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-15<br/>
 *
 */
public interface Sort {
    /**
     *
     * <b>描述：排序数组</b> <br/>
     * @author <b>创建人：</b> cdzhansihu@jd.com<br/>
     * <b>创建时间：</b> 2018-11-15 <br/>
     * <b>修改人：</b> cdzhansihu@jd.com<br/>
     * <b>时间：</b> 2018-11-15 <br/>
     * <b>修改内容：</b>  <br/>
     */
    void sort(Comparable[] a);

    /**
     *
     * <b>描述：数组a是否已经有序</b> <br/>
     * @author <b>创建人：</b> cdzhansihu@jd.com<br/>
     * <b>创建时间：</b> 2018-11-15 <br/>
     * <b>修改人：</b> cdzhansihu@jd.com<br/>
     * <b>时间：</b> 2018-11-15 <br/>
     * <b>修改内容：</b>  <br/>
     */
    boolean isSorted(Comparable[] a);
}