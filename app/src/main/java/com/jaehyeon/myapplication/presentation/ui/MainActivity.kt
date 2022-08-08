package com.jaehyeon.myapplication.presentation.ui

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jaehyeon.myapplication.R
import com.jaehyeon.myapplication.databinding.ActivityMainBinding
import com.jaehyeon.myapplication.presentation.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            model.getWeatherData()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launchWhenResumed {
            model.state.collectLatest {

                binding.model = it.weatherData

                if (it.error.isNotEmpty()) {
                    Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
                    Log.e(javaClass.simpleName, "onResume: ${it.error}", )
                }

                if (it.isLoading) binding.pr.visibility = View.VISIBLE
                else binding.pr.visibility = View.GONE
            }

//            model.channel.collectLatest {
//                binding.model = it.weatherData
//
//                if (it.error.isNotEmpty()) {
//                    Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
//                    Log.e(javaClass.simpleName, "onResume: ${it.error}", )
//                }
//
//                if (it.isLoading) binding.pr.visibility = View.VISIBLE
//                else binding.pr.visibility = View.GONE
//            }
        }
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.RESUMED) {
//                model.state.collectLatest {
//                    binding.model = it.weatherData
//
//                    if (it.error.isNotEmpty()) {
//                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
//                        Log.e(javaClass.simpleName, "onResume: ${it.error}", )
//                    }
//
//                    if (it.isLoading) binding.pr.visibility = View.VISIBLE
//                    else binding.pr.visibility = View.GONE
//                }
//            }
//        }
    }
}