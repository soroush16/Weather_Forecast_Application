import {useState} from "react";
import axios from "axios";

function SearchBar (props) {
    const [searchTerm, setSearchTerm] = useState('');

    const {setErrors, setWeatherList, inputName, buttonName} = props;

    const handleInputChange = (event) => {
        setSearchTerm(event.target.value);
        console.log(searchTerm)
    };

    const handleClick = async (event) => {
        event.preventDefault();
        const apiUrl = process.env.REACT_APP_API_URL;
        try {
            const dbResponse = await axios.get(apiUrl, {params:{city:searchTerm.trim()}});
            if (dbResponse.data) {
                setWeatherList(dbResponse.data);
                setErrors(null); // Reset error state if successful response
            }
        } catch (error) {
            setErrors(error);
        }
    }

    return (
    <div>
        <label className="element">{inputName}</label>
        <input className="element" id="city" type="text" value={searchTerm} onKeyDown={(event) => {
            if (event.key === 'Enter') {
                handleClick(event);
            }
        }} onChange={(event)=> handleInputChange(event)} />
        <button className="element" onClick={handleClick}>{buttonName}</button>
    </div>
    );

}

export default SearchBar;