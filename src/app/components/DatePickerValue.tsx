'use client'
import React from 'react';
import dayjs, { Dayjs } from 'dayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';

interface DatePickerValueProps {
  onDateChange: (startDate: Dayjs | null, endDate: Dayjs | null) => void;
}

const DatePickerValue: React.FC<DatePickerValueProps> = ({ onDateChange }) => {
  const [startDate, setStartDate] = React.useState<Dayjs | null>(null);
  const [endDate, setEndDate] = React.useState<Dayjs | null>(null);

  React.useEffect(() => {
    onDateChange(startDate, endDate);
  }, [startDate, endDate, onDateChange]);

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <div>
        <DatePicker
          label="Start Date"
          value={startDate}
          onChange={(newValue) => setStartDate(newValue as Dayjs | null)}
        />
        <DatePicker
          label="End Date"
          value={endDate}
          onChange={(newValue) => setEndDate(newValue as Dayjs | null)}
        />
      </div>
    </LocalizationProvider>
  );
};

export default DatePickerValue;