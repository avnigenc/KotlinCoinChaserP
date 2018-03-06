package zig.avnigenc.cryptotracking.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_layout.view.*
import zig.avnigenc.cryptotracking.R
import zig.avnigenc.cryptotracking.model.CryptoModel
import zig.avnigenc.cryptotracking.utils.Constants
import zig.avnigenc.cryptotracking.utils.inflate
import java.util.*

class CryptoAdapter : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {
    private var cryptoCoins: List<CryptoModel> = Collections.emptyList()


    override fun getItemCount(): Int = cryptoCoins.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder = CryptoViewHolder(parent.inflate(R.layout.crypto_layout))

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {

        val coin = cryptoCoins.get(position)


        holder.apply {
            coinName.text = coin.name
            coinSymbol.text = coin.symbol
            coinPrice.text = coin.price_try
            oneHourChange.text = coin.percent_change_1h + "%"
            twentyFourHourChange.text = coin.percent_change_24h + "%"
            sevenDayChange.text = coin.percent_change_7d + "%"


            Picasso.with(itemView.context).load(Constants.imageUrl + coin.symbol.toLowerCase() + ".png").into(coinIcon)


            oneHourChange.setTextColor(Color.parseColor(when {
                coin.percent_change_1h.contains("-") -> "#ff0000"
                else -> "#32CD32"
            }))

            twentyFourHourChange.setTextColor(Color.parseColor(when {
                coin.percent_change_24h.contains("-") -> "#ff0000"
                else -> "#32CD32"
            }))

            sevenDayChange.setTextColor(Color.parseColor(when {
                coin.percent_change_7d.contains("-") -> "#ff0000"
                else -> "#32CD32"
            }))
        }



    }

    class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var coinName = view.coinName
        var coinSymbol = view.coinSymbol
        var coinPrice = view.priceTryText
        val oneHourChange = view.percentChange1hText
        var twentyFourHourChange = view.percentChange24hText
        var sevenDayChange = view.percentChange7dayText
        var coinIcon = view.coinIcon
    }

    fun updateData(cryptoCoins: List<CryptoModel>) {
        this.cryptoCoins = cryptoCoins
        notifyDataSetChanged()
    }
}


