package cn.itsource.yigou.query;

/**
 * @author lzctuoxie
 * @version v1.0
 * @description: TODO
 * @date 2019/5/16
 * @ClassName:
 */
public class BaseQuery {

    private Integer size = 1;

    private Integer page = 10;

    private String keyword;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public BaseQuery(Integer size, Integer page, String keyword) {
        this.size = size;
        this.page = page;
        this.keyword = keyword;
    }

    public BaseQuery() {

    }

    @Override
    public String toString() {
        return "BaseQuery{" +
                "size=" + size +
                ", page=" + page +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
