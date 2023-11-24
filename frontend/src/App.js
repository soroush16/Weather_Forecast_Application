import {useState} from "react";
import WeatherShowList from "./components/WeatherShowList";
import SearchBar from "./components/SearchBar";


function App() {
  const [weatherList, setWeatherList] = useState([{}]);
  const [errors, setErrors] = useState(null);

  return (
      <div className="app-container">
        <h1 className="title-header">Weather Forecast</h1>
        <SearchBar setErrors={setErrors} setWeatherList={setWeatherList} inputName="City Name" buttonName="Get Forecast"/>
        <div>
          <WeatherShowList error = {errors} weatherList = {weatherList}/>
        </div>
      </div>
  )
}

export default App;
