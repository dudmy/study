package example

/**
 * This example implements the famous "99 Bottles of Beer" program
 * See http://99-bottles-of-beer.net/
 *
 * The point is to print out a song with the following lyrics:
 *
 *     The "99 bottles of beer" song
 *
 *     99 bottles of beer on the wall, 99 bottles of beer.
 *     Take one down, pass it around, 98 bottles of beer on the wall.
 *
 *     98 bottles of beer on the wall, 98 bottles of beer.
 *     Take one down, pass it around, 97 bottles of beer on the wall.
 *
 *       ...
 *
 *     2 bottles of beer on the wall, 2 bottles of beer.
 *     Take one down, pass it around, 1 bottle of beer on the wall.
 *
 *     1 bottle of beer on the wall, 1 bottle of beer.
 *     Take one down, pass it around, no more bottles of beer on the wall.
 *
 *     No more bottles of beer on the wall, no more bottles of beer.
 *     Go to the store and buy some more, 99 bottles of beer on the wall.
 *
 * Additionally, you can pass the desired initial number of bottles to use (rather than 99)
 * as a command-line argument
 */

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        showLyrics(99)
    } else {
        try {
            showLyrics(args[0].toInt())
        } catch (e: NumberFormatException) {
            println("Please enter an integer number. You have passed '${args[0]}'.")
        }
    }
}

fun showLyrics(count: Int) {

    println("The \"$count bottles of beer\" song\n")

    var bottles = count

    while (bottles > 0) {
        val currentBottles = bottlesOfBeer(bottles)
        val nextBottles = bottlesOfBeer(--bottles)

        println("$currentBottles on the wall, $currentBottles.\n" +
                "Take one down, pass it around, $nextBottles on the wall.\n")
    }
    println("No more bottles of beer on the wall, no more bottles of beer.\n" +
            "Go to the store and buy some more, 99 bottles of beer on the wall.")
}

fun bottlesOfBeer(count: Int): String =
        when (count) {
            0 -> "no more"
            1 -> "1 bottle"
            else -> "$count bottles"
        } + " of beer"