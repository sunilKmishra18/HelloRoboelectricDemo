package com.sunilmishra.helloroboelectricdemo;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import static com.sunilmishra.helloroboelectricdemo.ProjectTestRunner.assertViewIsVisible;
import static java.util.logging.Level.CONFIG;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.robolectric.RobolectricTestRunner.CONFIG_PROPERTIES;

/**
 * Created by M1027054 on 1/31/2017.
 * Test Class
 */
@RunWith(ProjectTestRunner.class)
@Config(constants = BuildConfig.class)
public class NewActivityTest {
    private NewActivity activity;
    private View button;

    @Before
    public void setUp() throws Exception {

        activity=Robolectric.setupActivity(NewActivity.class);
        activity.onCreate(null);

        button = activity.findViewById(R.id.crazy_button);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveButton() throws Exception {
        assertViewIsVisible(button);
    }
/*
    @Test
    public void buttonShouldDoSomethingCrazy() throws Exception {
        button.performClick();
        assertTrue(activity.conditionWasMet);
    }*/



}
