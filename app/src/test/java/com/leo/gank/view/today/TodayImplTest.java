package com.leo.gank.view.today;

import com.leo.gank.RxUnitTestTools;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;

import static org.mockito.Mockito.mock;

/**
 * Created by leo on 2016/6/7
 * Function
 */
@RunWith(RobolectricGradleTestRunner.class)
public class TodayImplTest {

    private String year, month, day;
    private TodayPresenter TodayImpl;

    @Before
    public void setUp() throws Exception {
        RxUnitTestTools.openRxTools();



        year = "2016";
        month = "06";
        day = "07";

        TodayImpl = new TodayPresenter(mock(TodayFragment.class));

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testData() throws Exception{

    }


    @Test
    public void updateView() throws Exception {

//        String time = year + "-" + month + "-" + day;
//        final DayModel[] result = {null};
//        Observable.concat(DayCache.getCacheObservable(time)
//                , DayServiceToModel.getDayData(year, month, day))
//                .takeFirst(dayModel -> dayModel != null)
//                .subscribe(dayModel -> {
//                            result[0] = dayModel;
//                            Assert.assertEquals(result[0].getCategory().size(), 10);
//                        }
//                );

//        DayServiceToModel.getDayData(year, month, day);

    }


    @Test
    public void openRefresh() throws Exception {

    }

    @Test
    public void closeRefresh() throws Exception {

    }

}