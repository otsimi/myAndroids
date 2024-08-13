package com.instantloan.equiloan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class newUserRegistrationFragment : Fragment() {
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.newuser_registration, container, false)
        setupButtonListeners(view)
        return view
    }

    private fun navigateTo(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun setupButtonListeners(view: View) {
        view.findViewById<Button>(R.id.proceedToVerify)?.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + 1
        }
    }
}
