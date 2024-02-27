package com.shrey.my_book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
//import android.widget.Toolbar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameWorkLayout: FrameLayout
    lateinit var navigationView: NavigationView
    var previousMenueItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.cordinatorLayout)
        frameWorkLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationLayout)
        toolbar = findViewById(R.id.toolbar)
        setToolbar()

        openDashboardAsDefault() //To open Dashboard as default. The fun is declared in later part of the code

        val actionBarDrawerLayout = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,// which helps the navigation layout slide in and slide out
            R.string.open_drawer,
            R.string.close_drawer

        )
        drawerLayout.addDrawerListener(actionBarDrawerLayout) // We have made ham functional but not home button. So id doesn't work yet
        actionBarDrawerLayout.syncState() // ham to back arrow and vice-versa

        // Adding listener to navigationView items
        navigationView.setNavigationItemSelectedListener {

           if (previousMenueItem != null) {
               previousMenueItem?.isChecked = false
           }
            it.isCheckable = true
            it.isChecked = true
            previousMenueItem = it

            when (it.itemId) { // it is a boolean
                R.id.dashboard -> {
                    openDashboardAsDefault() // Same thing as below but declared a fun for it. looks more organized
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.frameLayout, DashboardFragments())
//                       // .addToBackStack("Dashboard")
//                        .commit()//This commits the transaction. Calling commit() applies the changes made by the transaction. It's important to call commit() after making changes to ensure that the changes take effect.
//                    drawerLayout.closeDrawers() //This method closes any open drawers associated with the DrawerLayout. It's often called after a navigation action to close the drawer if it was open.
//                    supportActionBar?.title="Dashboard"

                }


                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, ProfileFragment())
                        // .addToBackStack("Profile")  Because we are making use of onBackPressed() inbuilt function
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "Profile"

                }

                R.id.favourites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, FavouriteFragment())
                        // .addToBackStack("Favourites")
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "Favourites"
                }

                R.id.about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AboutFragment())
                        // .addToBackStack("About")
                        .commit()
                    supportActionBar?.title = "About"
                    drawerLayout.closeDrawers()


                }
            }


            return@setNavigationItemSelectedListener true
        }
    }

    fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    //To add the click listeners to the actionBar in order to make home button on action bar functional.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id =
            item.itemId //This line retrieves the ID of the selected menu item using the itemId property of the MenuItem object passed as a parameter to the function. The id variable will be used to check which menu item was selected.
        if (id == android.R.id.home) { // This line checks if the ID of the selected menu item is equal to android.R.id.home. The android.R.id.home constant represents the home or up button in the app bar.
            drawerLayout.openDrawer(GravityCompat.START) // If the selected menu item is the home button, this line opens the navigation drawer associated with the drawerLayout. The GravityCompat.START parameter
            // specifies that the drawer should open from the start edge (left edge in left-to-right languages, right edge in right-to-left languages) of the layout.
        }
        return super.onOptionsItemSelected(item)
    }

    //Call this fun inside onCreate method to open Dashboard as default i.e whenever you open the app
    fun openDashboardAsDefault() {
        val D_fragment = DashboardFragments()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, D_fragment)
        transaction.commit()
        supportActionBar?.title = "Dashboard"
        navigationView.setCheckedItem(R.id.dashboard)
        drawerLayout.closeDrawers()
    }

    override fun onBackPressed() { //To change the back button functionality
        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout) // Grabs the fragments that is currently displayed in the frameLayout/frame
        when (frag) {
            //When the frame has any other fragment apart from DashboardFragment, then open dashboardFragment when back button is pressed
            !is DashboardFragments -> openDashboardAsDefault()
            else -> super.onBackPressed() //else back button functions as default behaviour i.e exits the app
        }
    }


}