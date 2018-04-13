package com.knowledgerepository.back.model;

import org.springframework.beans.support.PagedListHolder;

import java.util.List;


public final class PageListHolderBuilder {

    private final PagedListHolder<?> pageListHolder;
    private final int currentPageIndex;
    private final int smallestPageIndexDisplayedInPagination;
    private final int biggestPageIndexDisplayedInPagination;
    private final int pageCount;

    private PageListHolderBuilder(Builder builder) {
        this.pageListHolder = builder.pagedListHolder;
        this.currentPageIndex = builder.currentPageIndex;
        this.smallestPageIndexDisplayedInPagination = builder.smallestPageIndexDisplayedInPagination;
        this.biggestPageIndexDisplayedInPagination = builder.biggestPageIndexDisplayedInPagination;
        this.pageCount = builder.pageCount;
    }

    public List<?> getPageList() {
        return pageListHolder.getPageList();
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public int getSmallestPageIndexDisplayedInPagination() {
        return smallestPageIndexDisplayedInPagination;
    }

    public int getBiggestPageIndexDisplayedInPagination() {
        return biggestPageIndexDisplayedInPagination;
    }

    public int getPageCount() {
        return pageCount;
    }

    public static class Builder {

        private final PagedListHolder<?> pagedListHolder;
        private int currentPageIndex;
        private int smallestPageIndexDisplayedInPagination;
        private int biggestPageIndexDisplayedInPagination;
        private int pageCount;


        public Builder(List<?> pageSource) {
            if (pageSource == null) {
                throw new IllegalArgumentException("PageListHolderBuilder source and pageListHolder size cannot be null!");
            }
            this.pagedListHolder = new PagedListHolder<>(pageSource);
        }

        public Builder withPageSize(int pageSize) {
            this.pagedListHolder.setPageSize(pageSize);
            return this;
        }

        public Builder withSetPage(int pageNumber) {
            this.pagedListHolder.setPage(pageNumber - 1);  // pageListHolder counts from 0, set to -1 to be user friendly
            return this;
        }

        public Builder withCalculatePagesIndexesAndPageCount() {
            this.currentPageIndex = pagedListHolder.getPage() + 1;
            this.smallestPageIndexDisplayedInPagination = Math.max(1, currentPageIndex - 5);
            this.biggestPageIndexDisplayedInPagination = Math.min(smallestPageIndexDisplayedInPagination + 10, pagedListHolder.getPageCount());
            this.pageCount = pagedListHolder.getPageCount();
            return this;
        }


        public PageListHolderBuilder build() {
            return new PageListHolderBuilder(this);
        }

    }
}
