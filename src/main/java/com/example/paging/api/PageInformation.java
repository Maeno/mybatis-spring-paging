package com.example.paging.api;

public class PageInformation {

    private int offset;
    private int limit;
    private boolean first;
    private boolean last;
    private int totalPages;
    private int pageSize;
    private int totalRecords;
    private int pageNo;

    public PageInformation(final Builder builder) {
        this.pageSize = builder.pageSize;
        this.pageNo = builder.pageNo;
        this.first = builder.first;
        this.last = builder.last;
        this.totalPages = builder.totalPages;
        this.totalRecords = builder.totalRecords;
        this.offset = builder.offset;
        this.limit = builder.limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getPageNo() {
        return pageNo;
    }

    public static class Builder {

        private final int pageNo;
        private final int pageSize;
        private boolean first;
        private boolean last;
        private int totalRecords;
        private int totalPages;
        private int offset;
        private int limit;

        public Builder(final int pageNo, final int pageSize) {
            this.pageNo = pageNo;
            this.pageSize = pageSize;
        }

        public PageInformation build() {
            buildPageInfo();
            buildSQLCondition();
            return new PageInformation(this);
        }

        private void buildSQLCondition() {
            this.offset = (pageNo - 1) * pageSize;
            this.limit = pageSize;
        }

        private void buildPageInfo() {
            this.totalPages = (int)Math.ceil(totalRecords / pageSize);
            if (pageNo == 1) {
                this.first = true;
                this.last = false;
            } else if (pageNo == totalPages) {
                this.first = false;
                this.last = true;
            } else {
                this.first = false;
                this.last = false;
            }
        }

        public PageInformation.Builder totalRecords(final int totalRecords) {
            this.totalRecords = totalRecords;
            return this;
        }
    }
}
