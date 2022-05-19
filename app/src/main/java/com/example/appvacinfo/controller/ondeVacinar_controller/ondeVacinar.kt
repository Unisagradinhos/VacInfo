package com.example.appvacinfo.controller.ondeVacinar_controller

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.appvacinfo.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class ondeVacinar : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    lateinit var mapa: GoogleMap
    lateinit var ultimalocalizacao: Location
    lateinit var localizacaoClient: FusedLocationProviderClient

    companion object {
        private const val LOCATION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_onde_vacinar)

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


    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE)
            return
        }
        mapa.isMyLocationEnabled = true
        localizacaoClient.lastLocation.addOnSuccessListener(this){
                location ->
            if (location != null){
                ultimalocalizacao = location
                val latAtual = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(latAtual)
                mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(latAtual,12f))
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(latAtual,15f))
            }
        }
    }

    private fun placeMarkerOnMap(latAtual: LatLng) {
        val markOptions = MarkerOptions().position(latAtual)
        markOptions.title("$latAtual")
        mapa.addMarker(markOptions)
    }

    override fun onMarkerClick(p0: Marker)= false
    }



