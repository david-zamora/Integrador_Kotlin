/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

import java.util.*

data class Parkable(var vehicle : Vehicle){

    fun checkOutVehicle(val plate : String, onSuccess: ){

    }
}

data class Parking(val vehicles: MutableSet<Vehicle>){ //Se define como Set ya que no requerimos de un orden y no acepta datos dobles.

    val MaxCupo = 20

    fun addVehicle(vehicle: Vehicle): Boolean{
        return if (this.vehicles.size < MaxCupo){
            this.vehicles.add(vehicle)
            true
        }else{
            false
        }
    }

    fun checkIn(vehicle: Vehicle){
        if (addVehicle(vehicle)){
            println("Welcome to Alkeparking")
        }else{
            println("Sorry, the check-in failed")
        }
    }
}
    data class Vehicle(val plate: String, val type : VehicleType, val checkInTime : Calendar, val discountCard : String?=null){

        val MINUTES_IN_MILISECONDS = 60000

        val parkedTime: Long
            get() =(Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

        override fun equals(other: Any?): Boolean{
            if(other is Vehicle) {
                return this.plate == other.plate
            }
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return this.plate.hashCode()
        }
    }

    enum class VehicleType(val vehicletype : String, val cost: Int){
        CAR("Auto", 20),
        BIKE("Moto", 15),
        MINIBUS("Minibus", 25),
        BUS("Bus", 30);
    }


    fun main() {
        val car = Vehicle("AAA111", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
        val moto = Vehicle("AAB11", VehicleType.BIKE, Calendar.getInstance())
        val minibus = Vehicle("ABB123", VehicleType.MINIBUS, Calendar.getInstance())
        val bus = Vehicle("BCC321", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002" )
        val car1 = Vehicle("ACA111", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_003")
        val moto1 = Vehicle("AFB11", VehicleType.BIKE, Calendar.getInstance())
        val minibus1 = Vehicle("MBB123", VehicleType.MINIBUS, Calendar.getInstance())
        val bus1 = Vehicle("DCC321", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_004" )
        val car2 = Vehicle("KAA111", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_005")
        val moto2 = Vehicle("LAB11", VehicleType.BIKE, Calendar.getInstance())
        val minibus2 = Vehicle("UBB123", VehicleType.MINIBUS, Calendar.getInstance())
        val bus2 = Vehicle("JCC321", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_006" )
        val car3 = Vehicle("NAA111", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_007")
        val moto3 = Vehicle("MAB11", VehicleType.BIKE, Calendar.getInstance())
        val minibus3 = Vehicle("EBB123", VehicleType.MINIBUS, Calendar.getInstance())
        val bus3 = Vehicle("WCC321", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_008" )
        val car4 = Vehicle("SAA111", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_009")
        val moto4 = Vehicle("QAB11", VehicleType.BIKE, Calendar.getInstance())
        val minibus4 = Vehicle("HBB123", VehicleType.MINIBUS, Calendar.getInstance())
        val bus4 = Vehicle("GCC321", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_010" )
        val car5 = Vehicle("GCC321", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_010" )
        val parking = Parking(mutableSetOf())

        val lista = listOf(car, moto, minibus, bus, car1, moto1, minibus1, bus1, car2, moto2, minibus2, bus2, car3, moto3, minibus3, bus3, car4, moto4, minibus4, bus4, car5)
        lista.forEach{
            parking.checkIn(it)
        }
//        val car = Vehicle("AAA111", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")

        /*	val car2 = Vehicle("AAA111", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
            val isCar2Inserted = parking.vehicles.add(car2)
          */

        //println(parking.vehicles.contains(car))
        /* println(parking.vehicles.contains(moto))
         println(parking.vehicles.contains(minibus))
         println(parking.vehicles.contains(bus))

       */
        // println(parking)


    }