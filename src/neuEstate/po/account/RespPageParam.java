package neuEstate.po.account;

import java.util.List;

/**
 * Created by RuiPeng on 2017/7/31.
 */
public class RespPageParam {
    private List rows;  //数据或行数
    private int total;  //数据总数

    public RespPageParam() {
    }

    public RespPageParam(List rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
