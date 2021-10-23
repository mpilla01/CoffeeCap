class User {
    username;
    points;
    consumedList = [];
    favorites = [];
    caffeineIntake;
    constructor(username, points) {
        this.username = username;
        this.points = points;
        caffeineIntake = 0;
    }
    //name
    getName() {
        return this.username;
    }

    setName(username) {
        this.username = username;
    }

    //points
    getPoint() {
        return this.points;
    }

    addPoints(points) {
        this.points += points;
    }


    //consumedList
    getConsumedList() {
        return this.consumedList;
    }

    addConsumed(coffee) {
        this.consumedList.push(coffee);
    }


    //favorites
    getFavorites() {
        return this.favorites;
    }

    addFavorite(coffee) {
        this.favorites.push(coffee);
    }


    //caffeineIntake
    getCaffeineIntake() {
        return this.caffeineIntake;
    }

    setCaffeineIntake(caffeineIntake) {
        this.caffeineIntake = caffeineIntake;
    }
    

  }