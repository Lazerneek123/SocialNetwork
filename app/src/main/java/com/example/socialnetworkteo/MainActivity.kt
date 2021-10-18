package com.example.socialnetworkteo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.socialnetworkteo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_friends, R.id.nav_friend1, R.id.nav_friend2), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private var EXTRA_MESSAGE : String = "id"

    fun listenerFriend1(view: View) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,0)
        startActivity(intent)
    }

    fun listenerFriend2(view: View) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,1)
        startActivity(intent)
    }

    fun listenerFriend3(view: View) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,2)
        startActivity(intent)
    }

    fun listenerFriend4(view: View) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,3)
        startActivity(intent)
    }

    fun listenerFriend5(view: View) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,4)
        startActivity(intent)
    }

    fun listenerFriend6(view: View) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,5)
        startActivity(intent)
    }

    fun listenerFriend7(view: View) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE,6)
        startActivity(intent)
    }

    fun listenerInformation(item: MenuItem) {
        Toast.makeText(this, R.string.information_app, Toast.LENGTH_LONG).show()
    }
}