package com.example.valorantagentapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.valorantagentapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root) //

        val dataAgent = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<ValorantAgents>("EXTRA_AGENT", ValorantAgents::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<ValorantAgents>("EXTRA_AGENT")
        }

        if (dataAgent != null) {
            binding.tvItemName.text = dataAgent.name
            binding.tvItemRole.text = dataAgent.role
            binding.tvItemDescription.text = dataAgent.description
            binding.tvDescriptionStrenght.text = dataAgent.strength
            binding.tvDescriptionWeaknesses.text = dataAgent.weakness
            binding.imageView.setImageResource(dataAgent.photo)

            binding.actionShare.setOnClickListener {
                shareAgentDetails(dataAgent)
            }

        } else {

        }

    }

    private fun shareAgentDetails(agent: ValorantAgents) {
        val shareText = "Ini agant favorit saya:\n" +
                "Name: ${agent.name}\n" +
                "Role: ${agent.role}\n" +
                "Description: ${agent.description}\n" +
                "Strength: ${agent.strength}\n" +
                "Weakness: ${agent.weakness}"

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        startActivity(Intent.createChooser(shareIntent, "Share agent kamu via"))
    }


}