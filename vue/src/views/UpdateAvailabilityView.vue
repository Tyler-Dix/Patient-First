<template>
    <body>
        <div class="home">
            <global-header />
        </div>
        <div class="doc-availability-conditions">
            <doc-availability-conditions v-bind:offices="offices" />
        </div>
        <div class="doc-time-blocks">
            <doc-time-blocks  v-bind:scheduleStatuses="scheduleStatuses" />
        </div>
        
        
    </body>
</template>

<script>
import GlobalHeader from '../components/GlobalHeader.vue';
import doctorAvailabilityService from '../services/DoctorAvailabilityService';
import DocTimeBlocks from '../components/DocTimeBlocks.vue';
import officesService from '../services/OfficesService';
import OfficeDetails from '../components/OfficeDetails.vue';
import DocAvailabilityConditions from '../components/DocAvailabilityConditions.vue';


export default {
    components: {
        GlobalHeader,
        DocTimeBlocks,
        // OfficeDetails,
        DocAvailabilityConditions,

    },
    data() {
        return {
            //timeBlocks: [],
            officeTimeBlocks: [],
            offices: [],
            officeHours: {
                officeHoursStartTime: '',
                officeHoursEndTime: ''
            },
            scheduleStatuses: [],
        };
    },
    methods: {
        // getAllTimeBlocks() {
        //     doctorAvailabilityService.listAllTimeBlocks()
        //         .then(response => {
        //             this.timeBlocks = response.data;
        //             })
        //         .catch(error => {
                
        //         })
        // },
        // getTimeBlocksByOfficeHours(startTimeId, endTimeId) {
        //     doctorAvailabilityService.listTimeBlocksByOfficeHours(startTimeId, endTimeId)
        //         .then(response => {
        //             this.officeTimeBlocks = response.data;
        //             })
        //         .catch(error => {
                    
        //             })
        // },
        // getOffices(doctorId) {
        //     officesService.listOfficesByDoctorId(doctorId)
        //         .then(response => {
        //         this.offices = response.data;
        //             // this.officeHours.officeHoursStartTime = 
        //             // TODO: Determine how to get this working properly
        //         })
        //         .catch(error => {
        //         this.handleErrorResponse();
        //         })
        // },
        getScheduleStatuses() {
            doctorAvailabilityService.listScheduleStatuses()
                .then(response => {
                    this.scheduleStatuses = response.data;
                    })
                .catch(error => {
                
                })
            // getOfficeHours(doctorId)
            }
        },
    created() {
        //this.getAllTimeBlocks();
        this.getScheduleStatuses();
        // this.getOffices(1);
        // TODO: Figure out how to map in doctorId FROM userId (logged in user) IF the user is a Doctor
    }
};
</script>

<style scoped>
@import '../css/styles.css';
</style>../services/DoctorAvailabilityService