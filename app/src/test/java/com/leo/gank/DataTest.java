package com.leo.gank;

import com.leo.gank.data.day.DayServiceToModel;
import com.leo.gank.model.day.DayModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import rx.observers.TestSubscriber;

/**
 * Created by leo on 2016/6/8
 * Function
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 19)
public class DataTest {

    private String year, month, day;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        year = "2016";
        month = "06";
        day = "07";
    }

    @Test
    public void getData() throws Exception {
        TestSubscriber<DayModel> subscriber = new TestSubscriber<>();
        DayServiceToModel.getDayData(year, month, day).subscribe(subscriber);
        subscriber.assertNoErrors();
    }
}
