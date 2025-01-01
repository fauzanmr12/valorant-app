package com.example.valorantagentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvAgents: RecyclerView
    private val list = ArrayList<ValorantAgents>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAgents = findViewById(R.id.rv_agents)
        rvAgents.setHasFixedSize(true)

        list.addAll(getListAgents())
        showRecyclerList()
    }


    private fun showRecyclerList() {
        rvAgents.layoutManager = LinearLayoutManager(this)
        val listAgentsAdapter = ListAgentsAdapter(list)
        rvAgents.adapter = listAgentsAdapter
    }

    private fun getListAgents(): Collection<ValorantAgents> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataStrengths = resources.getStringArray(R.array.data_strengths)
        val dataWeaknesses = resources.getStringArray(R.array.data_weaknesses)

        val dataPhoto = arrayOf(
            R.drawable.brimstone,
            R.drawable.viper,
            R.drawable.omen,
            R.drawable.sova,
            R.drawable.sage,
            R.drawable.phoenix,
            R.drawable.jett,
            R.drawable.raze,
            R.drawable.cypher,
            R.drawable.killjoy
        )
        val listHero = ArrayList<ValorantAgents>()
        for (i in dataName.indices) {
            val hero = ValorantAgents(dataName[i], dataRole[i], dataDescription[i], dataPhoto[i], dataStrengths[i], dataWeaknesses[i] )
            listHero.add(hero)
        }
        return listHero
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutMeActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}