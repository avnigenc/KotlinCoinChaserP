package zig.avnigenc.cryptotracking.model

data class CryptoModel(
        val id: String,
        val name: String,
        val symbol: String,
        val price_try: String,
        val percent_change_1h: String,
        val percent_change_24h: String,
        val percent_change_7d: String
)

