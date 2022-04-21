package com.airfore.cell_info

import android.content.Context
import androidx.annotation.NonNull

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

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "cell_info") {

      val net = NetMonster()
      net.requestData(context!!, result)

    } else if (call.method == "sim_info") {

      val net = NetMonster()
      net.simsInfo(context!!,result)

    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    cellInfoChannel.setMethodCallHandler(null)
  }
}
