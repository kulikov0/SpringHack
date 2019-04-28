package ru.rhdv.springhackapplication.util.extention

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import ru.mail.mailhackathonapplication.R

fun FragmentManager.findFragment(position: BottomNavigationPosition): Fragment {
    return findFragmentByTag(position.getTag()) ?: position.createFragment()
}

fun FragmentManager.detach() {
    findFragmentById(R.id.main_container)?.also {
        beginTransaction().detach(it).commitNow()
    }
}

fun FragmentManager.attach(fragment: Fragment, tag: String) {
    if (fragment.isDetached) {
        beginTransaction().attach(fragment).commitNow()
    } else {
        beginTransaction().add(R.id.main_container, fragment, tag).commitNow()
    }
    beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitNow()
}

fun FragmentManager.attachToBackStack(fragment: Fragment, tag: String) {
    beginTransaction().replace(R.id.main_container,fragment, tag).addToBackStack(tag).commit()
}