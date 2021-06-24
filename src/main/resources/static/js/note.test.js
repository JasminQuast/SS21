
import { mount } from '@vue/test-utils'
import note from './note.js';
global.axios = {
    get() { return Promise.resolve({ data: []}) },
    post() { return Promise.resolve('') }
}

test('shows greeting with user name',  async () =>  {
    const wrapper = mount(note, {
        props:{
            user: 'Max'
        }
    });
    expect(wrapper.text()).toContain('Hallo Max, ich hoffe du hattest einen schönen Tag!')
})
