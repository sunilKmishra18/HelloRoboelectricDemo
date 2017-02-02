package com.sunilmishra.helloroboelectricdemo;

import android.graphics.drawable.Drawable;
import android.view.View;

import org.junit.runners.model.InitializationError;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by M1027054 on 1/30/2017.
 */

public class ProjectTestRunner extends RobolectricTestRunner {
    /**
     * Creates a runner to run {@code testClass}. Looks in your working directory for your AndroidManifest.xml file
     * and res directory by default. Use the {@link Config} annotation to configure.
     *
     * @param testClass the test class to be run
     * @throws InitializationError if junit says so
     */
    public ProjectTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    public static String getResourceString(int resourceId) {
        return RuntimeEnvironment.application.getString(resourceId);
    }

    /*public static Drawable getResourceDrawable(int resourceId) {
        return RuntimeEnvironment.application.getApplicationContext().getResources().getDrawable(resourceId);
    }*/

    public static void assertViewIsVisible(View view) {
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.VISIBLE));
    }

    public static void assertViewIsHidden(View view) {
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.GONE));
    }
}
