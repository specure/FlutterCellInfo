package com.airfore.cell_info

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import kotlinx.coroutines.CoroutineScope

/** CellInfoPlugin */
class CellInfoPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var cellInfoChannel : MethodChannel
  private lateinit var simInfoChannel : MethodChannel
  private  var context : Context? = null

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    context =  flutterPluginBinding.applicationContext

    cellInfoChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "cell_info")
    cellInfoChannel.setMethodCallHandler(this)

    simInfoChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "sim_info")
    simInfoChannel.setMethodCallHandler(this)
  }

  @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    val permissionLocation =
      ContextCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    val permissionReadPhoneState =
      ContextCompat.checkSelfPermission(context!!, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED

    if (call.method == "cell_info") {
      if (permissionLocation && permissionReadPhoneState) {
        val net = NetMonster()
        net.requestData(context!!, result)
      } else {
        result.success(null);
        return;
      }
    } else if (call.method == "sim_info") {
      if (permissionLocation && permissionReadPhoneState) {
        val net = NetMonster()
        net.simsInfo(context!!, result)
      } else {
        result.success(null);
        return;
      }
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    cellInfoChannel.setMethodCallHandler(null)
  }
}
