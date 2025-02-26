package com.vinilazzeri.whatsapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vinilazzeri.whatsapp.fragments.ChatFragment
import com.vinilazzeri.whatsapp.fragments.ContactsFragment

class ViewPagerAdapter (
    val tabs: List<String>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return tabs.size //listOf("Chats", "Contacts")
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            1 -> return ContactsFragment()
        }
        return ChatFragment()
    }
}