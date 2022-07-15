package com.example.kotlincourseappivanov

data class Weather (val city: City = getDefaultCity(), val temperature: Int, val feelsLike: Int)

data class City (val name: String, val lat: Double, val lon: Double)

fun getDefaultCity() = City("Москва", 43.3372, 131.4118)

fun getWorldCities(): List<Weather> {
    return listOf(
        Weather(City("Лондон", 51.182561298, -0.1323145), 1, 2),
        Weather(City("Токио", 123.1251521, 12.831842981), 3, 4),
        Weather(City("Париж", 1231.182561298, -0.568568), 5, 6),
        Weather(City("Берлин", 32241.1241241, -0.12412414), 7, 8),
        Weather(City("Рим", 523454361.1241241, 45523.154645323145), 9, 10),
        Weather(City("Минск", 7808751.12455, -0.67867), 11, 12),
        Weather(City("Стамбул", 51.123145, -0.7808790), 13, 14),
        Weather(City("Вашингтон", 86.1287680, 12412.87978), 15, 16),
        Weather(City("Киев", 51231.0384917, -0.430985), 17, 18),
        Weather(City("Пекин", 1214.12412754, -0.12481274), 19, 20)
    )
}

fun getRussianCities(): List<Weather> {
    return listOf(
        Weather(City("Москва", 51.182561298, -0.1323145), 1, 2),
        Weather(City("Санкт-Петербург", 123.1251521, 12.831842981), 3, 4),
        Weather(City("Новосибирск", 1231.182561298, -0.568568), 5, 6),
        Weather(City("Екатеринбург", 32241.1241241, -0.12412414), 7, 8),
        Weather(City("Нижний Новгород", 523454361.1241241, 45523.154645323145), 9, 10),
        Weather(City("Казань", 7808751.12455, -0.67867), 11, 12),
        Weather(City("Челябинск", 51.123145, -0.7808790), 13, 14),
        Weather(City("Омск", 86.1287680, 12412.87978), 15, 16),
        Weather(City("Ростов на Дону", 51231.0384917, -0.430985), 17, 18),
        Weather(City("Уфа", 1214.12412754, -0.12481274), 19, 20)
    )
}