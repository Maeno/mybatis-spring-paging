//package com.example.paging.wrapper;
//
//import com.example.paging.api.core.PagingCondition;
//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
//
//public class RowBoundsWrapperTest {
//
//    @Test
//    public void normalConstructor() throws Exception {
//        final String tableName = "hoge";
//        final int dispSize = 100;
//        final PagingCondition sut = new PagingCondition.Builder(tableName, dispSize).build();
//        assertThat(sut.getTableName(), is(tableName));
//        assertThat(sut.getDispSize(), is(dispSize));
//    }
//
//    @Test
//    public void emptyTableNameInConstructor() throws Exception {
//        try {
//            new PagingCondition.Builder("", 100).build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("tableName must not be null and empty."));
//        }
//    }
//
//    @Test
//    public void nullTableNameInConstructor() throws Exception {
//        try {
//            new PagingCondition.Builder(null, 100).build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("tableName must not be null and empty."));
//        }
//    }
//
//    @Test
//    public void normalCurrentPage() throws Exception {
//        final String tableName = "hoge";
//        final int dispSize = 100;
//        final int currentPage = 1;
//        final PagingCondition sut = new PagingCondition.Builder(tableName, dispSize).currentPage(currentPage).build();
//        assertThat(sut.getTableName(), is(tableName));
//        assertThat(sut.getDispSize(), is(dispSize));
//        assertThat(sut.getCurrentPage(), is(currentPage));
//    }
//
//    @Test
//    public void zeroNumberDispSizeInConstructor() throws Exception {
//        try {
//            new PagingCondition.Builder("hoge", 0).build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("dispSize must be one or greater."));
//        }
//    }
//
//    @Test
//    public void negativeNumberDispSizeInConstructor() throws Exception {
//        try {
//            new PagingCondition.Builder("hoge", -1).build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("dispSize must be one or greater."));
//        }
//    }
//
//    @Test
//    public void zeroNumberCurrentPage() throws Exception {
//        try {
//            new PagingCondition.Builder("hoge", 100).currentPage(0).build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("currentPage must be one or greater."));
//        }
//    }
//
//    @Test
//    public void negativeNumberCurrentPage() throws Exception {
//        try {
//            new PagingCondition.Builder("hoge", 100).currentPage(-1).build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("currentPage must be one or greater."));
//        }
//    }
//
//    @Test
//    public void firstAndLastAreSameTrueValue() throws Exception {
//        try {
//            new PagingCondition.Builder("hoge", 100).first().last().build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("please specify a different value for first and last."));
//        }
//    }
//
//    @Test
//    public void nextAndPrevAreSameTrueValue() throws Exception {
//        try {
//            new PagingCondition.Builder("hoge", 100).next().prev().build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("please specify a different value for next and prev."));
//        }
//    }
//
//    @Test
//    public void firstAndNextAreSameTrueValue() throws Exception {
//        try {
//            new PagingCondition.Builder("hoge", 100).next().first().build();
//            fail();
//        } catch (Exception e) {
//            assertThat(e.getMessage(), is("please specify only one of first, last, next and prev."));
//        }
//    }
//}
