package com.instantloan.equiloan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class signupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        val tabToolbar = findViewById<Toolbar>(R.id.toolbar)
        val tabViewPager = findViewById<ViewPager2>(R.id.view_pager)
        val tabTabLayout = findViewById<TabLayout>(R.id.tab_layout)

        setSupportActionBar(tabToolbar)
        setupViewPager(tabViewPager, tabTabLayout)
//        if (savedInstanceState == null) {
//            loadFragment(newUserRegistrationFragment())
//        }
    }
//    private fun loadFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .commit()
//    }

    private fun setupViewPager(viewPager: ViewPager2, tabLayout: TabLayout) {
        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(newUserRegistrationFragment(), "Registration")
        adapter.addFragment(furtherDetailsFragment(), "Email Verification")
        adapter.addFragment(employmentDetailsFragment(), "Work Details")
        adapter.addFragment(documentUploadFragment(), "Document uploads")
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }

}

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragmentList: MutableList<Fragment> = mutableListOf()
    private val fragmentTitleList: MutableList<String> = mutableListOf()

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }
}
