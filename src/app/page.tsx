'use client'
import React, { useEffect, useState } from "react";
import dayjs, { Dayjs } from "dayjs";
import DatePickerValue from "./components/DatePickerValue";
import QueryType from "./components/QueryType";
import axiosInstance from './Api/axiosConfig';
import { Box, Button, Container, Grid, Typography } from "@mui/material";
import Table from "./components/FlightTable";
import FlightTable from "./components/FlightTable";


interface Flight {
  origin: string;
  destination: string;
  price?: number;
  equipment?: string;
  className?: string;
}

export default function Home() {
  const [startDate, setStartDate] = useState<Dayjs | null>(null);
  const [endDate, setEndDate] = useState<Dayjs | null>(null);
  const [inputValue, setInputValue] = useState("");
  const [inputValue2, setInputValue2] = useState("");
  const [inputValue3, setInputValue3] = useState("");
  const [inputValue4, setInputValue4] = useState("");
  const [inputValue5, setInputValue5] = useState("");

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
    setLoading(true);
    setError(null);
    const params = new URLSearchParams({
      startDate: startDate ? startDate.format('YYYY-MM-DD') : '',
      endDate: endDate ? endDate.format('YYYY-MM-DD') : '',
      origin: inputValue,
    });

    if (inputValue2) {
      params.append('destination', inputValue2);
    }

    if (inputValue3) {
      params.append('maxPrice', inputValue3);
    }
    if (inputValue4) {
      params.append('className', inputValue4);
    }
    if (inputValue5) {
      params.append('equipment', inputValue5);
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
  const handleInputChange4 = (value: string) => setInputValue4(value);
  const handleInputChange5 = (value: string) => setInputValue5(value);

  return (
    <Container maxWidth="sm">
      <Grid container spacing={2} margin={2}>
        <div>
          <Typography variant="h4" align="center">Flight Search</Typography>
          <DatePickerValue onDateChange={handleDateChange} />
          <QueryType
            onInputChange1={handleInputChange1}
            onInputChange2={handleInputChange2}
            onInputChange3={handleInputChange3}
            onInputChange4={handleInputChange4}
            onInputChange5={handleInputChange5}
          />
          
          <Box display="flex" justifyContent="center" width="100%" mt={2}>
            <Button variant="contained" onClick={handleSearch}>Search</Button>
          </Box>
          
          <Box mt={4}>
            <Typography variant="h5" align="center">Results</Typography>
            <FlightTable flights={flights} loading={loading} error={error} />
          </Box>
        </div>
      </Grid>
    </Container>
  );
}