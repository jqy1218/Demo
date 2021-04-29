package com.lirenqi.navigationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return

        // Set up Action Bar
        val navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

//        val drawerLayout : DrawerLayout? = findViewById(R.id.drawer_layout)
//        appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.home_dest, R.id.deeplink_dest),
//            drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        val sideNavView = findViewById<NavigationView>(R.id.nav_view)
//        sideNavView?.setupWithNavController(navController)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
//        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        // The NavigationView already has these same navigation items, so we only add
//        // navigation items to the menu here if there isn't a NavigationView
//        if (navigationView == null) {
//            menuInflater.inflate(R.menu.nav_drawer_menu, menu)
//            return true
//        }
        return retValue
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        // Have the NavigationUI look for an action or destination matching the menu
        // item id and navigate there if found.
        // Otherwise, bubble up to the parent.
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
                || super.onOptionsItemSelected(item)
        // TODO END STEP 9.2
    }

    override fun onSupportNavigateUp(): Boolean {
        // Allows NavigationUI to support proper up navigation or the drawer layout
        // drawer menu, depending on the situation
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }
}