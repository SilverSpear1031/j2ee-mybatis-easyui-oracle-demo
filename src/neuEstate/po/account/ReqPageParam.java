package neuEstate.po.account;

/**
 * Created by RuiPeng on 2017/7/31.
 */
public class ReqPageParam {
    private int page = 1;   //请求页
    private int rows = 10;   //显示行数

    public ReqPageParam() {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
