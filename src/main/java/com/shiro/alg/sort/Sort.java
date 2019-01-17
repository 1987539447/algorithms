
package com.shiro.alg.sort;

/**
 * <b>描述：排序算法接口</b> <br/>
 *
 * <b>时间：</b>2018-11-15<br/>
 *
 */
public interface Sort {
    /**
     *
     * <b>描述：排序数组</b> <br/>
     * @author <b>创建人：</b> <br/>
     * <b>创建时间：</b> 2018-11-15 <br/>
     * <b>修改人：</b> <br/>
     * <b>时间：</b> 2018-11-15 <br/>
     * <b>修改内容：</b>  <br/>
     */
    void sort(Comparable[] a);

    /**
     *
     * <b>描述：数组a是否已经有序</b> <br/>
     * @author <b>创建人：</b> <br/>
     * <b>创建时间：</b> 2018-11-15 <br/>
     * <b>修改人：</b> <br/>
     * <b>时间：</b> 2018-11-15 <br/>
     * <b>修改内容：</b>  <br/>
     */
    boolean isSorted(Comparable[] a);
}