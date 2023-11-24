
function WeatherShow ({weather}) {
    if (!weather || Object.keys(weather).length === 0) {
        return null;
    }else {
        return (
            <div className="weather-container">
                <div className="result-element">
                    <h2>Date</h2>
                    <p>{weather.date}</p>
                </div>
                <div className="result-element">
                    <h2>City</h2>
                    <p>{weather.city}</p>
                </div>
                <div className="result-element">
                    <h2>Day Phenomenon</h2>
                    <p>{weather.dayPhenomenon}</p>
                </div>
                <div className="result-element">
                    <h2>Night Phenomenon</h2>
                    <p>{weather.nightPhenomenon}</p>
                </div>
                <div className="result-element">
                    <h2>Maximum Temperature</h2>
                    <p>{weather.tempMax}</p>
                </div>
                <div className="result-element">
                    <h2>Minimum Temperature</h2>
                    <p>{weather.tempMin}</p>
                </div>
            </div>
        )
    }


}

export default WeatherShow;