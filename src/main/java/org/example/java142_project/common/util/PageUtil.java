package com.example.java142_project.common.util;

public class PageUtil {
    //当前页
    private int currentPage;
    //总页数
    private int pageNum;
    //每页记录数
    private int pageSize = 4;
    //总记录数
    private int totalCount;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        if (this.currentPage<1){
            this.currentPage = 1;
        }
        if (this.currentPage>this.pageNum){
            this.currentPage = this.pageNum;
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum() {
        this.pageNum = totalCount/pageSize + (totalCount%pageSize==0?0:1);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
