package com.example.week3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivityProfileBinding
import com.example.week3.viewmodel.ProfileViewModel

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding.viewModel = viewModel

        binding.textViewFullName.setOnClickListener {
            DialogEditor("FullName", viewModel).show(
                supportFragmentManager,
                "Dialog Editor"
            )
        }
        binding.textViewEmail.setOnClickListener {
            DialogEditor("Email", viewModel).show(
                supportFragmentManager,
                "Dialog Editor"
            )
        }
        binding.textViewPhone.setOnClickListener {
            DialogEditor("PhoneNumber", viewModel).show(
                supportFragmentManager,
                "Dialog Editor"
            )
        }

        listenerSuccessEvent()
        listenerErrorEvent()
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMsg ->
            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { successUserKey ->
            onDialogSubmitFinish(successUserKey)
        }
    }

    private fun onDialogSubmitFinish(fieldName: String) {
    }

}