package com.fps69.assignment

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.fps69.assignment.Adapter.RewardAdapter
import com.fps69.assignment.DataClass.Reward
import com.fps69.assignment.DataClass.RewardResponse
import com.fps69.assignment.Utilss.ApiUtilities
import com.fps69.assignment.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


// Fetch rewards for a specific user ID
        fetchRewards()




    }

    private fun fetchRewards() {
        val apiInterface = ApiUtilities.getApiInterface()
        val call = apiInterface.getRewards()

        call.enqueue(object : Callback<List<Reward>> {
            override fun onResponse(call: Call<List<Reward>>, response: Response<List<Reward>>) {
                if (response.isSuccessful) {
                    val rewardsResponse = response.body()
                    rewardsResponse?.let {
                        setupRecyclerView(it)
                    }
                } else {
                    Log.e("Response", "Response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Reward>>, t: Throwable) {
                Log.e("Response", "Failed to fetch data: ${t.message}")
            }
        })
    }

    private fun setupRecyclerView(rewardList: List<Reward>) {
        binding.rewardRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RewardAdapter(rewardList)
        }
    }
}