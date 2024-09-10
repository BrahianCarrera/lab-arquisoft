'use client'
import React, { useEffect, useState } from "react";
import dayjs, { Dayjs } from "dayjs";
import DatePickerValue from "./components/DatePickerValue";
import QueryType from "./components/QueryType";
import axiosInstance from './Api/axiosConfig';

interface Flight {
  origin: string;
  destination: string;
  price?: number;
}

export default function Home() {
  const [startDate, setStartDate] = useState<Dayjs | null>(dayjs('2022-04-17'));
  const [endDate, setEndDate] = useState<Dayjs | null>(null);
  const [inputValue, setInputValue] = useState("");
  const [inputValue2, setInputValue2] = useState("");
  const [inputValue3, setInputValue3] = useState("");
  const [flights, setFlights] = useState<Flight[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetchFlights();
  }, []);

  const fetchFlights = async () => {
    const params = new URLSearchParams({
      startDate: startDate ? startDate.format('YYYY-MM-DD') : '',
      endDate: endDate ? endDate.format('YYYY-MM-DD') : '',
      origin: inputValue,
    });

    try {
      const response = await axiosInstance.get(`/flights/search?${params.toString()}`);
      setFlights(response.data);
      setLoading(false);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'An error occurred');
      setLoading(false);
    }
  };

  const handleDateChange = (newStartDate: Dayjs | null, newEndDate: Dayjs | null) => {
    setStartDate(newStartDate);
    setEndDate(newEndDate);
  };

  const handleSearch = async () => {
    const params = new URLSearchParams({
      startDate: startDate ? startDate.format('YYYY-MM-DD') : '',
      endDate: endDate ? endDate.format('YYYY-MM-DD') : '',
      origin: inputValue,
    });

    if (inputValue2) {
      params.append('destination', inputValue2);
    }

    if (inputValue3) {
      params.append('price', inputValue3);
    }

    try {
      const response = await axiosInstance.get(`/flights/search?${params.toString()}`);
      setFlights(response.data);
      setLoading(false);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'An error occurred');
      setLoading(false);
    }
  };
    
  const handleInputChange1 = (value: string) => setInputValue(value);
  const handleInputChange2 = (value: string) => setInputValue2(value);
  const handleInputChange3 = (value: string) => setInputValue3(value);

  return (
    <div>
      <h1>Search Flights</h1>
      <DatePickerValue onDateChange={handleDateChange} />
      <QueryType
        onInputChange1={handleInputChange1}
        onInputChange2={handleInputChange2}
        onInputChange3={handleInputChange3}
      />
      <button onClick={handleSearch}>Search</button>
      <div>
        <h1>Results</h1>
        {loading && <p>Loading...</p>}
        {error && <p>Error: {error}</p>}
        {!loading && !error && (
          <ul>
            {flights.map((flight, index) => (
              <li key={index}>
                {flight.origin} to {flight.destination} - Price: {flight.price}
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}