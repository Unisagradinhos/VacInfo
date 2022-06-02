package com.example.appvacinfo.controller.ondeVacinar_controller

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.appvacinfo.MainActivity
import com.example.appvacinfo.R
import com.example.appvacinfo.controller.sobreController.SobreActivity
import com.example.appvacinfo.controller.faqController.FaqActivity
import com.example.appvacinfo.controller.mitosController.MitosActivity
import com.example.appvacinfo.model.Locals
import com.example.appvacinfo.model.carregarJsonLocals
import com.example.appvacinfo.quandoVacinar
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.navigation.NavigationView
import org.json.JSONException

class ondeVacinar : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    lateinit var mapa: GoogleMap
    lateinit var ultimalocalizacao: Location
    lateinit var localizacaoClient: FusedLocationProviderClient

    companion object {
        private const val LOCATION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Onde Vacinar"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_onde_vacinar)
        drawerConfig()

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_map_ondeVacinar) as SupportMapFragment
        mapFragment.getMapAsync(this)
        localizacaoClient = LocationServices.getFusedLocationProviderClient(this)
    }



    override fun onMapReady(googleMap: GoogleMap) {
       mapa = googleMap
        mapa.uiSettings.isZoomControlsEnabled = true
        mapa.setOnMarkerClickListener(this)
        setUpMap()
    }


    private fun setUpMap()
    {
        val file: String = "data/locals/locals.json"

        try
        {
                val locals = carregarJsonLocals(file, this)
                if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED )
                    {
                        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE)
                        return
                    }
                mapa.isMyLocationEnabled = true
                localizacaoClient.lastLocation.addOnSuccessListener(this)
                {
                location ->
                if (location != null)
                    {
                    ultimalocalizacao = location
                    val latAtual = LatLng(location.latitude, location.longitude)
                    placeMarkerOnMap(locals)
                    mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(latAtual,12f))
                    mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(latAtual,15f))
                    }
                }
        }catch(e: JSONException)
            {
                e.printStackTrace()
            }
    }

    private fun placeMarkerOnMap(locals: List<Locals>)
    {
        locals.forEach{
                local ->  val marker = mapa.addMarker(MarkerOptions()
                .title(local.name)
                .snippet(local.addres)
                .position(LatLng(local.lat,local.long)))}
    }

    override fun onMarkerClick(p0: Marker)= false

    //DRAWER: -->
    private lateinit var toggle : ActionBarDrawerToggle
    private fun drawerConfig(){
        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    val tela_home = Intent(this, MainActivity::class.java)
                    startActivity(tela_home)
                }
                R.id.nav_calendar -> {
                    val tela_QuandoVacinar = Intent(this, quandoVacinar::class.java)
                    startActivity(tela_QuandoVacinar)
                }
                R.id.nav_location -> {
                    val tela_OndeVacinar = Intent (this, ondeVacinar::class.java)
                    startActivity(tela_OndeVacinar)
                }
                R.id.nav_vaccines->{
                    val tela_Vacinas = Intent (this, FaqActivity::class.java)
                    startActivity(tela_Vacinas)
                }
                R.id.nav_diseases -> {
                    val tela_Doencas = Intent (this, MitosActivity ::class.java)
                    startActivity(tela_Doencas)
                }
                R.id.nav_about ->  {
                    val tela_Sobre = Intent (this, SobreActivity::class.java)
                    startActivity(tela_Sobre)
                }
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    //<<-- DRAWER:
}






