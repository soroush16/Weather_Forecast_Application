import WeatherShow from "./WeatherShow";

function WeatherShowList (props) {
    const {error, weatherList} = props;

    const renderWeather = () => {
        if(error === null){
            return weatherList.map((weather, index) => {
                return <WeatherShow key={index} weather={weather} />
            });
        }else {
            return <div className="title-header">No Data Found for this city</div>
        }
    }

    return renderWeather()
}

export default WeatherShowList;