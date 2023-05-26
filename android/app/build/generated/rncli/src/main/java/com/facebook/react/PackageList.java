
package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import java.util.Arrays;
import java.util.ArrayList;

// @adobe/react-native-aepassurance
import com.adobe.marketing.mobile.reactnative.assurance.RCTAEPAssurancePackage;
// @adobe/react-native-aepcore
import com.adobe.marketing.mobile.reactnative.RCTAEPCorePackage;
// @adobe/react-native-aeptarget
import com.adobe.marketing.mobile.reactnative.target.RCTAEPTargetPackage;
// @adobe/react-native-aepuserprofile
import com.adobe.marketing.mobile.reactnative.userprofile.RCTAEPUserProfilePackage;
// react-native-safe-area-context
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
// react-native-screens
import com.swmansion.rnscreens.RNScreensPackage;

public class PackageList {
  private Application application;
  private ReactNativeHost reactNativeHost;
  private MainPackageConfig mConfig;

  public PackageList(ReactNativeHost reactNativeHost) {
    this(reactNativeHost, null);
  }

  public PackageList(Application application) {
    this(application, null);
  }

  public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig config) {
    this.reactNativeHost = reactNativeHost;
    mConfig = config;
  }

  public PackageList(Application application, MainPackageConfig config) {
    this.reactNativeHost = null;
    this.application = application;
    mConfig = config;
  }

  private ReactNativeHost getReactNativeHost() {
    return this.reactNativeHost;
  }

  private Resources getResources() {
    return this.getApplication().getResources();
  }

  private Application getApplication() {
    if (this.reactNativeHost == null) return this.application;
    return this.reactNativeHost.getApplication();
  }

  private Context getApplicationContext() {
    return this.getApplication().getApplicationContext();
  }

  public ArrayList<ReactPackage> getPackages() {
    return new ArrayList<>(Arrays.<ReactPackage>asList(
      new MainReactPackage(mConfig),
      new RCTAEPAssurancePackage(),
      new RCTAEPCorePackage(),
      new RCTAEPTargetPackage(),
      new RCTAEPUserProfilePackage(),
      new SafeAreaContextPackage(),
      new RNScreensPackage()
    ));
  }
}
