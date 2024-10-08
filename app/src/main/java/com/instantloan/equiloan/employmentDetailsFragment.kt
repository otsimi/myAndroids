package com.instantloan.equiloan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class employmentDetailsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.employment_details, container, false
        )
        setupButtonListeners(view)
        return view
    }
    private fun navigateTo(activityClass: Class<*>) {
        startActivity(Intent(requireActivity(), activityClass))
    }
    private fun setupButtonListeners(view: View) {
        view.findViewById<Button>(R.id.proceed)?.setOnClickListener {
            navigateTo(documentUploadFragment::class.java)
        }
    }
}