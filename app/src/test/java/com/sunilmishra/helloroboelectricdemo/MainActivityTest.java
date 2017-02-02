package com.sunilmishra.helloroboelectricdemo;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;


import static com.sunilmishra.helloroboelectricdemo.ProjectTestRunner.assertViewIsHidden;
import static com.sunilmishra.helloroboelectricdemo.ProjectTestRunner.assertViewIsVisible;
import static com.sunilmishra.helloroboelectricdemo.ProjectTestRunner.getResourceString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.shadows.ShadowToast.getLatestToast;
import static org.robolectric.shadows.ShadowToast.getTextOfLatestToast;

/**
 * Created by M1027054 on 1/30/2017.
 */
@RunWith(ProjectTestRunner.class)
@Config(constants=BuildConfig.class)
public class MainActivityTest {
    private MainActivity activity;
    private TextView welcomeText;
    private ImageView image;
    private View button;

    @Before
    public void setUp() throws Exception {
        activity=Robolectric.setupActivity(MainActivity.class);

        welcomeText = (TextView) activity.findViewById(R.id.welcome_text_view);
        image = (ImageView) activity.findViewById(R.id.sun_earth_image);
        button = activity.findViewById(R.id.next_screen_button);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception {
        assertViewIsVisible(welcomeText);
    }

    @Test
    public void welcomeTextShouldEqualResource() throws Exception {
        assertThat(welcomeText.getText().toString(),
                equalTo(getResourceString(R.string.WELCOME_STRING)));
    }

    @Test
    public void welcomeTextClickShouldToastUser() throws Exception {
        welcomeText.performClick();
        assertThat(getTextOfLatestToast(),
                equalTo(getResourceString(R.string.WELCOME_TOAST)));
    }

    @Test
    public void shouldHaveImage() throws Exception {
        assertViewIsVisible(image);
    }

    /*@Test
    public void imageShouldEqualResourceDrawable() throws Exception {
        assertThat(image.getDrawable(),
                equalTo(getResourceDrawable(R.drawable.sun_earth)));
    }*/

    @Test
    public void shouldHaveHiddenButton() throws Exception {
        assertViewIsHidden(button);
    }

    @Test
    public void shouldShowButtonAfterImageClick() throws Exception {
        image.performClick();
        assertViewIsVisible(button);
    }

    /*@Test
    public void buttonClickShouldStartNewActivity() throws Exception {
        button.callOnClick();
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertEquals(MainActivity.class.getName(), shadowIntent.getIntentClass());


    }*/

    @Test
    public void shortToast_shouldToastStringPassedForShortDuration() throws Exception {
        String testString = "Test string";
        activity.shortToast(testString);
        assertThat(getTextOfLatestToast(), equalTo(testString));
        assertThat(getLatestToast().getDuration(),
                equalTo(Toast.LENGTH_SHORT));
    }
}
