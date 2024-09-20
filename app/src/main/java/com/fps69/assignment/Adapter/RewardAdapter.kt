package com.fps69.assignment.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fps69.assignment.DataClass.Reward
import com.fps69.assignment.databinding.ItemBinding

class RewardAdapter(private val rewardList: List<Reward>) :
    RecyclerView.Adapter<RewardAdapter.RewardViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RewardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        holder.bind(rewardList[position])
    }

    override fun getItemCount(): Int {
        return rewardList.size
    }

    class RewardViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // Bind the data with the view
        fun bind(reward: Reward) {
            binding.tvQuizName.text = reward.Quiz
            binding.tvRank.text = "Rank: ${reward.Rank}"
            binding.tvPrizeAmount.text = if (reward.Prize != null) "₹${reward.Prize}" else "₹ N/A"
            binding.tvCoupon.text = if (reward.Coupon_id != null) "Coupon: ${reward.Coupon_id}" else "Coupon: N/A"
            binding.tvScore.text = "Score: ${reward.Score}"
        }
    }
}